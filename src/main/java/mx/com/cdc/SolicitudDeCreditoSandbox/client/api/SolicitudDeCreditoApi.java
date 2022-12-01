package mx.com.cdc.SolicitudDeCreditoSandbox.client.api;

import com.google.gson.reflect.TypeToken;

import mx.com.cdc.SolicitudDeCreditoSandbox.client.ApiClient;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.ApiException;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.ApiResponse;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.Configuration;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.Pair;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.ProgressRequestBody;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.ProgressResponseBody;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.model.RequestExportarExpediente;
import mx.com.cdc.SolicitudDeCreditoSandbox.client.model.ResponseExportarExpediente;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolicitudDeCreditoApi {
    private ApiClient apiClient;

    public SolicitudDeCreditoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public SolicitudDeCreditoApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public okhttp3.Call exportarExpedienteCall(String xApiKey, RequestExportarExpediente exportar,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = exportar;
        String localVarPath = "/exportar/informacion";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (xApiKey != null)
            localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null)
            localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if (progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                            .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {};
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call exportarExpedienteValidateBeforeCall(String xApiKey, RequestExportarExpediente exportar,
            final ProgressResponseBody.ProgressListener progressListener,
            final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (exportar == null) {
            throw new ApiException("Missing the required parameter 'exportar' when calling exportarExpediente(Async)");
        }

        okhttp3.Call call = exportarExpedienteCall(xApiKey, exportar, progressListener, progressRequestListener);
        return call;
    }

    public ResponseExportarExpediente exportarExpediente(String xApiKey, RequestExportarExpediente exportar)
            throws ApiException {
        ApiResponse<ResponseExportarExpediente> resp = exportarExpedienteWithHttpInfo(xApiKey, exportar);
        return resp.getData();
    }

    public ApiResponse<ResponseExportarExpediente> exportarExpedienteWithHttpInfo(String xApiKey,
            RequestExportarExpediente exportar)
            throws ApiException {
        okhttp3.Call call = exportarExpedienteValidateBeforeCall(xApiKey, exportar, null, null);
        Type localVarReturnType = new TypeToken<ResponseExportarExpediente>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }
}
