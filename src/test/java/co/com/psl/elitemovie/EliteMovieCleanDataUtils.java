package co.com.psl.elitemovie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import co.com.psl.elitemovie.integration.util.EliteMovieConstants;

public class EliteMovieCleanDataUtils {

	public static void cleanAll() throws IOException {
		URL url = new URL(EliteMovieConstants.BASE_URL + "/rest/clean/");
		URLConnection httpConn = url.openConnection();

		InputStream inputStream = null;
		if (httpConn != null) {
			inputStream = httpConn.getInputStream();
		} else {
			throw new IOException("Connection is not established.");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));

		reader.readLine();
		reader.close();
	}

}
