package com.jaeshim.inflearn.spring.mvc.itemservice.domain.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepository {

  private static final Map<Long, Item> store = new HashMap<>();
  private static long sequence = 0L;

  public Item save(Item item) {
    item.setId(++sequence);
    store.put(item.getId(),item);

    return item;
  }

  public Item findById(Long id) {
    return store.get(id);
  }

  public List<Item> findAll() {
    return new ArrayList<>(store.values());
  }

  public void update(Long itemId,Item itemParam) {
    Item findItem = findById(itemId);
    findItem.setItemName(itemParam.getItemName());
    findItem.setPrice(itemParam.getPrice());
    findItem.setQuantity(itemParam.getQuantity());
    findItem.setOpen(itemParam.getOpen());
    findItem.setRegions(itemParam.getRegions());
    findItem.setItemType(itemParam.getItemType());
    findItem.setDeliveryCode(itemParam.getDeliveryCode());
  }

  public void clearStore() {
    store.clear();
  }
}
