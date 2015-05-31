package edu.train.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders", excerptProjection = OrderSummary.class)
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

}
