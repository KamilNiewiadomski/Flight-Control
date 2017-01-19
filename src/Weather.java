/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
final class Weather {
    private double temperature, visibility, clouds;
    private boolean isSnowing, isRaining, isStorm;
    private Wind wind;
    
    public Weather(){
        this.setTemperature(Engine.inputDouble("communique"));
        this.setVisibility(Engine.inputDouble("communique"));
        this.setClouds(Engine.inputDouble("communique"));
        this.setIsSnowing(Engine.inputBoolean(" "));
        this.setIsRaining(Engine.inputBoolean(" "));
        this.setIsStorm(Engine.inputBoolean(" "));
        this.setWind(new Wind());
    }
    public Weather(double temperature, double visibility, double clouds, 
            boolean isSnowing, boolean isRaining, boolean isStorm, Wind wind){
            this.temperature = temperature;
            this.visibility = visibility;
            this.clouds = clouds;
            this.isSnowing = isSnowing;
            this.isRaining = isRaining;
            this.isStorm = isStorm;
            this.wind = wind;
    }
    
    void setTemperature(double temperature){
        this.temperature = temperature;
    }
    void setVisibility(double visibility){
        this.visibility = visibility;
    }
    void setClouds(double clouds){
        this.clouds = clouds;
    }
    void setIsSnowing(boolean isSnowing){
        this.isSnowing = isSnowing;
    }
    void setIsRaining(boolean isRaining){
        this.isRaining = isRaining;
    }
    void setIsStorm(boolean isStorm){
        this.isStorm = isStorm;
    }
    void setWind(Wind wind){
        this.wind = wind;
    }

    private static class Wind {
        private short windDirection;
        private double windSpeed;
        public Wind() {
            this.setWindDirection((short)Engine.inputDouble(" "));
            this.setWindSpeed(Engine.inputDouble(" "));
        }
        public Wind(short windDirection, double windSpeed){
            this.windDirection = windDirection;
            this.windSpeed = windSpeed;
        }
        void setWindDirection(short windDirection){
            this.windDirection = windDirection;
        }
        void setWindSpeed(double windSpeed){
            this.windSpeed = windSpeed;
        }
    }    
}