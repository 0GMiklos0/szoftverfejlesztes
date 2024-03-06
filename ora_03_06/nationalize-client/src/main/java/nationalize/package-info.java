/**
 * Package to predict the nationality of a person based on their last name.
 * The current implementation uses the <a href="https://nationalize.io/">nationalize.io</a> API.
 *
 * Usage
 * {@snippet :
 * var client = NationalizeClient.newInstance();
 * var nationality = client.getNationality("Torvalds");
 * }
 */
package nationalize;