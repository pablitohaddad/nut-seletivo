package io.github.pablitohaddad.apipncp.model.dto.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ApiMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        if (origin == null) {
            return null;
        }
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();
        if (origin != null) {
            for (O o : origin) {
                destinationObjects.add(mapper.map(o, destination));
            }
        }
        return destinationObjects;
    }
}
