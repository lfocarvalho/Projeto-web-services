package com.project.services;

import com.project.entities.Order;
import com.project.repositories.OrderRepository;
import com.project.services.exceptions.DatabaseException;
import com.project.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    // MÉTODO NOVO PARA ATUALIZAR UM PEDIDO
    public Order update(Long id, Order obj) {
        try {
            Order entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // MÉTODO AUXILIAR PARA ATUALIZAR OS DADOS DO PEDIDO
    private void updateData(Order entity, Order obj) {
        entity.setMoment(obj.getMoment());
        entity.setStatus(obj.getStatus());
        // Não vamos alterar o cliente nem os itens de um pedido
    }
}