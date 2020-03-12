package com.github.dwasinge.items.repository;

import javax.enterprise.context.ApplicationScoped;

import com.github.dwasinge.items.domain.Item;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ItemRepository implements PanacheRepository<Item> {

}
