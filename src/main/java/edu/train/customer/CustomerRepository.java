package edu.train.customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers", excerptProjection = CustomerSummary.class)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

}
