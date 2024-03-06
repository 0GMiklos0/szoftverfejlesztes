package nationalize;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

/**
 * Client interface to query the possible countries of origin for a last name.
 * The {@link #newInstance()} method is provided to obtain a {@code NationalizeClient} object.
 */
public interface NationalizeClient {

    /**
     *
     * @param name a last name
     * @return the possible countries of origin for their last name specified
     * @throws feign.FeignException if any error occurs
     */
    @RequestLine("GET /?name={name}")
    Nationality getNationality(@Param("name") String name);

    /**
     * @return an object implementing the {@code NationalizeClient} interface
     */

    static NationalizeClient newInstance() {
        return Feign.builder()
                .decoder(new GsonDecoder(new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
                .target(NationalizeClient.class, "https://api.nationalize.io/");
    }

}
