package me.zeph.relations.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import me.zeph.relations.model.api.Allele;
import me.zeph.relations.service.AlleleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api(value = "Alleles", position = 1)
public class AlleleController {

	@Autowired
	private AlleleService alleleService;

	@ApiOperation(value = "Get Alleles by Kit Id")
	@ResponseStatus(OK)
	@RequestMapping(value = "/kits/{kitId}/alleles", method = GET, produces = APPLICATION_JSON_VALUE)
	public List<Allele> getAlleles(@PathVariable long kitId) {
		List<Allele> alleles = alleleService.getAlleles(kitId);
		for (Allele allele : alleles) {
			allele.add(selfLink(kitId, allele.getAlleleId()));
		}
		return alleles;
	}

	@RequestMapping(value = "/kits/{kitId}/alleles/{alleleId}", method = GET, produces = APPLICATION_JSON_VALUE)
	public Allele getAllele(@PathVariable long kitId, @PathVariable long alleleId) {
		Allele allele = alleleService.getAllele(kitId, alleleId);
		allele.add(selfLink(kitId, alleleId));
		return allele;
	}

	private Link selfLink(long kitId, long alleleId) {
		return linkTo(methodOn(AlleleController.class).getAllele(kitId, alleleId)).withSelfRel();
	}
}
