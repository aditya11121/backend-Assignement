# Automatic Irrigation System

Key features:
1. Location of the plot - In order to stop irrigation during the rainy weather.
2. Average Inflow Rate- In order to calculate the volume of water and duration of irrigation.
3. Area Watered per Irrigation- For accurate measures.
4. Volume of water per Irrigation- To send sensor the measure of water for irrigation.
5. Irrigation After Hours - scheduled Irrigation

Alert System:
If a sensor passes the threshold value of predefined failure count then its data will be saved in Alert table. So that we will be able to send push Notification to the user.

Rest Apis implementation for the following senarios-
1. Add new plot of land
2. Configure a plot of land
3. Edit a plot of land
4. List all plots and it's details

Thread Implementation for the following scenarios-
1. Integration interface with the sensor device once a plot of land need to be irrigate
2. Update the status of the slot once the request is successfully sent to the sensor device
3. Retry calls to the sensor device in case the sensor not available (pre configured)
4. Alerting system to be implemented in case the sensor not available and after exceeding the retry times.

