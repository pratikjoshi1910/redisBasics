package com.example.sapient.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.example.sapient.cache.CacheService;
import com.example.sapient.entity.Category;
import com.example.sapient.entity.Client;
import com.example.sapient.entity.Color;
import com.example.sapient.entity.Product;
import com.example.sapient.entity.SystemDetails;
import com.example.sapient.repository.CategoryRepository;
import com.example.sapient.repository.ClientRepository;
import com.example.sapient.repository.ColorRepository;
import com.example.sapient.repository.ProductRepository;
import com.example.sapient.repository.SystemDetailsRepo;
import com.example.sapient.resultMapper.BrandProductResult;

@Configuration
public class ProductCatalogConfiguration {

	@Autowired
	private CacheConfigurationFactory cacheConfigFactory;
	
	@Autowired
	ClientRepository clientRepo; 
	
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SystemDetailsRepo systemDetailRepo;
	
	@Autowired
    ProductRepository productRepo;
	
	@Autowired
	ColorRepository colorRepository;
	
	@Value("${cache.syncup.threashold :7200}")
	private long thresold;

	@PostConstruct
	void MakeTheCache() {
		insertData();
		updateCache();
	}

	private void insertData() {

		// client date 
		
		Color color = new Color(); 
		color.setCode(000l);
		color.setName("black");
		
		Color color1 = new Color(); 
		color1.setCode(001l);
		color1.setName("blue");
		
		Color color2 = new Color(); 
		color2.setCode(002l);
		color2.setName("green");
		
		List<Color> colors = new ArrayList<>(); 
		colors.add(color);
		colors.add(color1);
		colors.add(color2);
		
		colorRepository.saveAll(colors);
		
		
		Client client = new Client();
		client.setCode(11l);
		client.setName("dummyClient");
		
		
		Client client1 = new Client();
		client1.setCode(12l);
		client1.setName("dummyClient1");
		
		List<Client> clients = new ArrayList<Client>();
		clients.add(client);
		clients.add(client1);
		
		clientRepo.saveAll(clients);

			
		
		// category date
				
		Category category = new Category();
		category.setCode(111l);
		category.setName("dummyCategory");
		
		Category category1 = new Category();
		category1.setCode(112l);
		category1.setName("dummyCategory1");
		
		Category category2 = new Category();
		category2.setCode(113l);
		category2.setName("dummyCategory2");
		
		List<Category> categories = new ArrayList<>(); 
		categories.add(category);
		categories.add(category1);
		categories.add(category2);

		
		categoryRepository.saveAll(categories);
		
		// product data 
		
		Product product = new Product(); 
		product.setName("Nike1");
		product.setPrice(100.00);
		product.setColor(color);
		product.setProductCode(1111l);
		product.setClient(client);
		product.setCategory(category);
		
		Product product1 = new Product(); 
		product1.setName("Nike");
		product1.setPrice(100.00);
		product1.setColor(color1);

		product1.setProductCode(1112l);
		product1.setClient(client);
		product1.setCategory(category1);
		
		Product product2 = new Product(); 
		product2.setName("Nike");
		product2.setPrice(100.00);
		product2.setColor(color2);

		product2.setProductCode(1113l);
		product2.setClient(client1);
		product2.setCategory(category);
		
		Product product3 = new Product(); 
		product3.setName("Nike");
		product3.setPrice(100.00);
		product3.setColor(color2);

		product3.setProductCode(1114l);
		product3.setClient(client1);
		product3.setCategory(category);
		
		Product product4 = new Product(); 
		product4.setName("Nike");
		product4.setPrice(100.00);
		product4.setProductCode(1115l);
		product4.setClient(client);
		product4.setColor(color2);

		product4.setCategory(category2);

		List<Product> products = new ArrayList<>();
		products.add(product4); 
		products.add(product3); 
		products.add(product2); 
		products.add(product1); 
		products.add(product); 
		
		productRepo.saveAll(products);

	}

	private void updateCache() {
		if (getCacheDetails() || getCacheExpireStatus()) {
			// bring data from  db 
			List<BrandProductResult> brandData = productRepo.getAllProductByProductByClient(); 
			Map<Long, Set<Long>> brandMap = brandData.stream().collect(Collectors.groupingBy(BrandProductResult::getCode,HashMap::new,Collectors.mapping(BrandProductResult::getproductCode, Collectors.toSet())));
			List<BrandProductResult> categoryData = productRepo.getAllProductByCategory(); 
			Map<Long, Set<Long>> categoryMap = categoryData.stream().collect(Collectors.groupingBy(BrandProductResult::getCode,HashMap::new,Collectors.mapping(BrandProductResult::getproductCode, Collectors.toSet())));
			List<BrandProductResult> coloryData = productRepo.getProductByColor();
			Map<Long, Set<Long>> coloryMap = coloryData.stream().collect(Collectors.groupingBy(BrandProductResult::getCode,HashMap::new,Collectors.mapping(BrandProductResult::getproductCode, Collectors.toSet())));
			Map<String,Map<Long,Set<Long>>> cacheMap = new HashMap<>();
			cacheMap.put("brand", brandMap); 
			cacheMap.put("category", categoryMap); 
			cacheMap.put("color", coloryMap); 
			CacheService service=cacheConfigFactory.getBy("local");
			service.createCache(cacheMap);
			System.out.println(service.getCacheDate().size());
		}
	}

	private Boolean getCacheExpireStatus() {
		SystemDetails systemDetail = systemDetailRepo.findByCode(123L);
		if ((null != systemDetail) && (null != systemDetail.getDate())) {
			long diff = (System.currentTimeMillis() - systemDetail.getDate().longValue()) / 1000;
			if (diff > thresold) {
				return true;
			}
		}
		return false;
	}

	private Boolean getCacheDetails() {
		

		return true;
	}
}
