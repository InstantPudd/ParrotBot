package com.parrot.edge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdgeService {

    @Autowired
    private EdgeDao edgeDao;

    public Optional<Edge> getEdge(long id) {
        return edgeDao.getEdge(id);
    }
}
