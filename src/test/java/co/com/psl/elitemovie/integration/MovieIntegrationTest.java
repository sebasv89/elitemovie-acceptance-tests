package co.com.psl.elitemovie.integration;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import co.com.psl.elitemovie.EliteMovieCleanDataUtils;
import co.com.psl.elitemovie.integration.dto.MovieDto;
import co.com.psl.elitemovie.integration.dto.MovieLightWeightDto;
import co.com.psl.elitemovie.integration.util.EliteMovieConstants;

public class MovieIntegrationTest extends BaseIntegrationTest {

	@Test
	public void getMoviesTest() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MovieLightWeightDto[]> response = restTemplate.exchange(
				EliteMovieConstants.BASE_URL + "/rest/movie/", HttpMethod.GET,
				null, MovieLightWeightDto[].class);

		Assert.assertEquals(10, response.getBody().length);
	}

	@Test
	public void getMovieDetailsTest() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<MovieDto> response = restTemplate.exchange(
				EliteMovieConstants.BASE_URL + "/rest/movie/1", HttpMethod.GET,
				null, MovieDto.class);

		MovieDto result = response.getBody();
		Assert.assertEquals(
				"La historia de Niccolo Paganini, el más grande violinista y compositor del Siglo XIX. Apostó todo por la música, incluso su alma. Un viaje a través del delirio del compositor, la lujuria de sus pasiones, y el escándalo asociado a su fama. Protagonizada por el prodigioso músico David Garrett.",
				result.getDescription());
		Assert.assertEquals("El Violinista del Diablo", result.getName());
		Assert.assertEquals(1, result.getId());
		Assert.assertEquals("Jueves, Diciembre 18, 2014",
				result.getReleaseDateString());

	}

	@AfterTest
	public void cleanUp() throws IOException {
		EliteMovieCleanDataUtils.cleanAll();
	}

}
