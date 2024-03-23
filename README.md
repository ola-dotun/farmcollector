### Getting Started ##
The application can be started from the command line at the root directory by calling
`./mvnw spring-boot:run`

Once the application is started, the UI can be accessed on the browser at http://localhost:8080/
The seasons dropdown can be used to select the season-period combination, and the Search button
will trigger a fetch of the currently selected season.

The data (if any) is displayed in the table below the select.

The API endpoints used are:
1. `GET /seasons` - This fetches all available season-periods combination data and is used to populate the select dropdown.
2. `GET /reports{season-period-id}` - This fetches the data of the season-period selected.