package com.azure.cosmos;

import com.azure.cosmos.models.CosmosItemIdentity;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.FeedResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public class ItemOperationsBridge {


    public static <T> Mono<FeedResponse<T>> readManyAsync(CosmosAsyncContainer container,
                                                   List<CosmosItemIdentity> itemKeyList,
                                                   CosmosQueryRequestOptions options,
                                                   Class<T> klass) {
        return container.getDatabase()
                .getDocClientWrapper()
                .readMany(itemKeyList, container.getLink(), options, klass);
    }
}
