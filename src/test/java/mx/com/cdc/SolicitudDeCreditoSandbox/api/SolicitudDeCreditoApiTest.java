package mx.com.cdc.SolicitudDeCreditoSandbox.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.SolicitudDeCreditoSandbox.client.ApiClient;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.ApiException;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.api.SolicitudDeCreditoApi;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.model.RequestExportarExpediente;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.model.ResponseExportarExpediente;
import okhttp3.OkHttpClient;

public class SolicitudDeCreditoApiTest {
	private final SolicitudDeCreditoApi api = new SolicitudDeCreditoApi();
	private Logger logger = LoggerFactory.getLogger(SolicitudDeCreditoApiTest.class.getName());
	private ApiClient apiClient = null;
	private String xApiKey = "your_api_key";

	@Before
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void exportarExpedienteTest() throws ApiException {
		RequestExportarExpediente exportar = new RequestExportarExpediente();

		exportar.setIdOtorgante("kPDjCZpf");
		exportar.setFolio(new Long(1069));

		try {
			ResponseExportarExpediente response = api.exportarExpediente(xApiKey, exportar);

			Assert.assertTrue(response != null);
			if (response != null) {
				logger.info(response.toString());
			}
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
	}
}
