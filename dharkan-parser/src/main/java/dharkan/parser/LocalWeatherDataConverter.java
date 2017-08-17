package dharkan.parser;

/**
 * Created by bsimioni on 17/08/17.
 */

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalWeatherDataConverter {

    public static dharkan.domain.LocalWeatherData convert(dharkan.csv.model.LocalWeatherData csvLocalWeatherData, dharkan.csv.model.Station csvStation) {

        LocalDate date = csvLocalWeatherData.getDate();
        LocalTime time = csvLocalWeatherData.getTime();
        String skyCondition = csvLocalWeatherData.getSkyCondition();
        Float stationPressure = csvLocalWeatherData.getStationPressure();
        Float temperature = csvLocalWeatherData.getDryBulbCelsius();
        Float windSpeed = csvLocalWeatherData.getWindSpeed();

        // Convert the Station data:
        dharkan.domain.Station station = convert(csvStation);

        return new dharkan.domain.LocalWeatherData(station, date, time, temperature, windSpeed, stationPressure, skyCondition);
    }

    public static dharkan.domain.Station convert(dharkan.csv.model.Station csvStation) {
        String wban = csvStation.getWban();
        String name = csvStation.getName();
        String state = csvStation.getState();
        String location = csvStation.getLocation();
        Integer timeZone = csvStation.getTimeZone();
        dharkan.domain.GeoLocation geoLocation = new dharkan.domain.GeoLocation(csvStation.getLatitude(), csvStation.getLongitude());

        return new dharkan.domain.Station(wban, name, state, location, timeZone, geoLocation);
    }

}
