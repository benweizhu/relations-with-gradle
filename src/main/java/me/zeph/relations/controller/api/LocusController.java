package me.zeph.relations.controller.api;

import me.zeph.relations.model.LocusCode;
import me.zeph.relations.service.LocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static me.zeph.relations.constants.DataBase.AGCU_EX_22;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/locus", method = GET)
public class LocusController {

	@Autowired
	public LocusService locusService;

	@RequestMapping(produces = {APPLICATION_JSON_VALUE})
	public LocusCode getLocusCode(@RequestParam(value = "kit", defaultValue = AGCU_EX_22) String kit) {
		return locusService.getLocusCode(kit);
	}
}
