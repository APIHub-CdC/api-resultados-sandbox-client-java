# api-resultados-sandbox-client  [![GitHub Packages](https://img.shields.io/badge/Maven&nbsp;package-Last&nbsp;version-lemon)](https://github.com/orgs/APIHub-CdC/packages?repo_name=api-resultados-sandbox-client-java)

Círculo de Crédito: Expediente Sandbox
<br/><br/>

API para simular la extracción de información de solicitudes de crédito.<br/><br><img src='https://developer.circulodecredito.com.mx/sites/default/files/2020-10/circulo_de_credito-apihub.png' height='40' width='220'/></p><br/>

## Requisitos

1. Java 1.7+
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:
```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***cd src/test/java/mx/com/cdc/SolicitudDeCreditoSandbox/api/SolicitudDeCreditoApiTest.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
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
```
De igual manera, en el archivo **SolicitudDeCreditoApiTest.java**, se deberá modificar el siguiente fragmento de código con los datos correspondientes:

> **NOTA:** Para más ejemplos de simulación, consulte la colección de Postman.

```java
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
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```
