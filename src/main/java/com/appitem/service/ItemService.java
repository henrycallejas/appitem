package com.appitem.service;

import com.appitem.model.Item;
import com.appitem.repository.IRepository;
import com.appitem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IRepository<Item, Integer> {
    @Autowired
    ItemRepository repository;

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }

    @Override
    public Item save(Item entity) {
        return repository.save(entity);
    }

    @Override
    public Item update(Item entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(int id) {
        Item item = new Item();
        item.setItemId(id);
        repository.delete(item);
    }

    @Override
    public Item get(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}