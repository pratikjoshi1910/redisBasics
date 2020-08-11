package com.example.sapient.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.sapient.entity.Client;
import com.example.sapient.entity.SystemDetails;

public interface ClientRepository extends PagingAndSortingRepository<Client, UUID> ,JpaSpecificationExecutor<Client>{

	Client save(Client client);


}
