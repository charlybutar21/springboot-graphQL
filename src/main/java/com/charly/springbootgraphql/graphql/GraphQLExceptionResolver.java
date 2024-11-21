package com.charly.springbootgraphql.graphql;

import com.charly.springbootgraphql.exception.ResourceNotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolver;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class GraphQLExceptionResolver implements DataFetcherExceptionResolver {

    @Override
    public Mono<List<GraphQLError>> resolveException(Throwable exception, DataFetchingEnvironment environment) {
        if (exception instanceof ResourceNotFoundException) {
            GraphQLError error = GraphqlErrorBuilder.newError()
                    .message(exception.getMessage())
                    .errorType(ErrorType.NOT_FOUND)
                    .path(environment.getExecutionStepInfo().getPath())
                    .build();
            return Mono.just(Collections.singletonList(error));
        }

        return Mono.empty();
    }
}
