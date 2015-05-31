package edu.train.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = OrderItemSummary.class)
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Integer> {

}
