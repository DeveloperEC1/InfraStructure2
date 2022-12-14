package elior.com.infrastructure.data.retrofit;

import elior.com.infrastructure.data.models.Events;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GetDataService {

    @GET()
    Call<Events> getAllActivities(@Url String url);

}
