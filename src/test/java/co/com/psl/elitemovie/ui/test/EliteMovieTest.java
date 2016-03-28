package co.com.psl.elitemovie.ui.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import co.com.psl.elitemovie.ui.action.ConfirmationPageBehavior;
import co.com.psl.elitemovie.ui.action.SelectMoviePageBehavior;
import co.com.psl.elitemovie.ui.action.SelectSchedulePageBehavior;
import co.com.psl.elitemovie.ui.action.SelectSeatsPageBehavior;

public abstract class EliteMovieTest {

	private static final String ELITE_MOVIE_MAIN_URL = "http://192.168.99.100:8080/elitemovie";
	private SelectSchedulePageBehavior _selectSchedulePageBehavior;
	private ConfirmationPageBehavior _confirmationPageBehavior;
	private SelectMoviePageBehavior _selectMoviePageBehavior;
	private SelectSeatsPageBehavior _selectSeatsPageBehavior;

	private static WebDriver _webDriver;

	public static WebDriver getWebDriver() {
		return _webDriver;
	}

	@BeforeClass
	public void init() {

		_webDriver = new FirefoxDriver(new FirefoxProfile());
		_webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_webDriver.manage().window().maximize();
		_webDriver.get(ELITE_MOVIE_MAIN_URL);
	}

	@AfterClass
	public void close() {
		_webDriver.close();
	}

	public SelectMoviePageBehavior getSelectMoviePageBehavior() {
		if (_selectMoviePageBehavior == null) {
			_selectMoviePageBehavior = new SelectMoviePageBehavior(getWebDriver());
		}

		return _selectMoviePageBehavior;
	}

	public SelectSchedulePageBehavior getSelectSchedulePageBehavior() {
		if (_selectSchedulePageBehavior == null) {
			_selectSchedulePageBehavior = new SelectSchedulePageBehavior(getWebDriver());
		}
		return _selectSchedulePageBehavior;
	}

	public SelectSeatsPageBehavior getSelectSeatsPageBehavior() {
		if (_selectSeatsPageBehavior == null) {
			_selectSeatsPageBehavior = new SelectSeatsPageBehavior(getWebDriver());
		}
		return _selectSeatsPageBehavior;
	}

	public ConfirmationPageBehavior getConfirmationPageBehavior() {

		if (_confirmationPageBehavior == null) {
			_confirmationPageBehavior = new ConfirmationPageBehavior(getWebDriver());
		}
		return _confirmationPageBehavior;
	}
}
