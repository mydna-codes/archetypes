package ${package}.services;

import ${package}.entities.SampleEntity;

import java.util.List;

public interface SampleService {

    List<SampleEntity> getSamples();
    SampleEntity addSampleEntity(SampleEntity entity);

}