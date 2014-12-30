package me.zeph.relations.controller;

import me.zeph.relations.controller.web.ParentsController;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParentsControllerTest {
	@Test
	public void shouldGoToParentsPage() {
		ParentsController parentsController = new ParentsController();
		String viewName = parentsController.view();
		assertThat(viewName, is("parents"));
	}
}