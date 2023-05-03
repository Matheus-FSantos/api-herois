package io.github.MatheusFSantos.core.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum Race {
    HUMAN(1),
    ALIEN(2),
    DIVINE(3),
    CYBORG(4);
    
    private Integer code;
	
    private Race(Integer code) {
    	this.code = code;
    }
    
    public Integer getCode() {
    	return this.code;
    }
    
    public static String valueOf(Integer code) {
    	for(Race race : Race.values())
    		if(race.getCode() == code) {
    			switch (code) {
				case 1:
					return "Human";
				case 2: 
					return "Alien";
				case 3:
					return "Divine";
				case 4:
					return "Cyborg";
    			}
    		}
    	
		return null;
    }
}