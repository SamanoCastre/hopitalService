package com.emergency.system.entities;

import java.util.List;

public class GoogleDistanceMatrixApiResponse {
	
	List<Rows> rows;
	private List<String> destination_addresses;
	private List<String> origin_addresses;

	public List<String> getDestination_addresses() {
	    return destination_addresses;
	}

	public List<String> getOrigin_addresses() {
	    return origin_addresses;
	}

	public List<Rows> getRows() {
	    return rows;
	}

	public static class Rows {
	    List<Element> elements;

	    public List<Element> getElements() {
	        return elements;
	    }
	}


	public static class Element {

	    Distance distance;
	    Duration duration;

	    public Distance getDistance() {
	        return distance;
	    }

	    public Duration getDuration() {
	        return duration;
	    }
	}

	public static class Distance {
	    String text;
	    String value;

	    public String getText() {
	        return text;
	    }

	    public String getValue() {
	        return value;
	    }
	}

	public static class Duration {
	    String text;
	    String value;

	    public String getText() {
	        return text;
	    }

	    public String getValue() {
	        return value;
	    }
	}
}
