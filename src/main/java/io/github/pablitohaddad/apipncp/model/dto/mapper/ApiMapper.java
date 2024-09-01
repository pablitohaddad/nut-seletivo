package io.github.pablitohaddad.apipncp.model.dto.mapper;

import org.modelmapper.ModelMapper;

public class ApiMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        if (origin == null) {
            return null;
        }
        return mapper.map(origin, destination);
    }
}
