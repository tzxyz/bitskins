package org.zhuonima.bitskins;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhuonima.bitskins.items.models.Item;
import org.zhuonima.bitskins.items.services.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BitskinsApplicationTests {

	@Autowired
	private ItemService itemService;

	@Test
	public void contextLoads() {
		Item item = new Item();
		item.setAppName("asdasdasd");
		item = itemService.saveToDBFromResponse(item);
		item = itemService.saveToDBFromResponse(item);
		assert item.getId() != null;

		assert itemService.findAll(new PageRequest(1, 1)).getTotalPages() == 1;
	}

}
