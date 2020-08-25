package com.example.token.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.example.token.dto.StepDTO;
import com.example.token.dto.StepMapDTO;
import com.example.token.dto.WorkflowTypeDTO;
import com.example.token.entity.Source;
import com.example.token.entity.Step;
import com.example.token.entity.StepMap;
import com.example.token.entity.WorkflowType;
import com.example.token.repository.SourceRepository;
import com.example.token.repository.StepMapRepository;
import com.example.token.repository.StepRepository;
import com.example.token.repository.WorkflowTypeRepository;
import com.google.gson.Gson;
import org.springframework.core.io.ResourceLoader;
import java.io.File;

@Configuration
public class RsaDataConfig {

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	SourceRepository sourceRepository;

	@Autowired
	WorkflowTypeRepository workFlowTypeRepository;

	@Autowired
	StepRepository stepRepository;
	
	@Autowired 
	StepMapRepository stepMapRepository;

	@PostConstruct
	public void init() throws IOException {
		initilizeMaster();
	}

	private void initilizeMaster() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:source.json");
		File file = resource.getFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		Source[] samples = new Gson().fromJson(br, Source[].class);
		for (Source sample : samples)
			sourceRepository.save(sample);
		resource = resourceLoader.getResource("classpath:workflowType.json");
		file = resource.getFile();
		br = new BufferedReader(new FileReader(file));
		WorkflowTypeDTO[] workflowTypes = new Gson().fromJson(br, WorkflowTypeDTO[].class);
		for (WorkflowTypeDTO workflowTypeDTO : workflowTypes) {
			Optional<Source> source = sourceRepository.findById(workflowTypeDTO.getSource());
			WorkflowType workflowType = new WorkflowType();
			workflowType.setDesc(workflowTypeDTO.getDesc());
			workflowType.setId(workflowTypeDTO.getId());
			workflowType.setSource(source.get());
			workflowType.setIsError(workflowTypeDTO.getIsError());
			workflowType.setType(workflowTypeDTO.getType());
			workFlowTypeRepository.save(workflowType);
		}

		resource = resourceLoader.getResource("classpath:Steps.json");
		file = resource.getFile();
		br = new BufferedReader(new FileReader(file));
		StepDTO[] steps = new Gson().fromJson(br, StepDTO[].class);
		for (StepDTO stepDTO : steps) {
			Optional<Source> source = sourceRepository.findById(stepDTO.getSource());
			Step step = new Step();
			step.setDesc(stepDTO.getDesc());
			step.setTag(stepDTO.getTag());
			step.setId(stepDTO.getId());
			step.setSource(source.get());
			stepRepository.save(step);
		}

		resource = resourceLoader.getResource("classpath:stepmap.json");
		file = resource.getFile();
		br = new BufferedReader(new FileReader(file));
		StepMapDTO[] stepMaps = new Gson().fromJson(br, StepMapDTO[].class);
		for (StepMapDTO stepMapDTO : stepMaps) {
			Optional<Source> source = sourceRepository.findById(stepMapDTO.getSource());
			Optional<Step> step = stepRepository.findById(stepMapDTO.getStep());
			Optional<WorkflowType> workflowType = workFlowTypeRepository.findById(stepMapDTO.getWorkflowType());
			StepMap stepMap = new StepMap();
			stepMap.setId(stepMapDTO.getId());
			stepMap.setSeq(stepMapDTO.getSeq());
			stepMap.setStep(step.get());
			stepMap.setSource(source.get());
			stepMap.setWorkflowType(workflowType.get());
			stepMapRepository.save(stepMap);

		}
	}

}
