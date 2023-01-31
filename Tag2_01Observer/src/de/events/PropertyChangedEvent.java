package de.events;

public class PropertyChangedEvent {

    private final Object source;
    private final String propertyname;
    private final Object oldValue;
    private final Object newValue;

    public PropertyChangedEvent(final Object source, String propertyname, Object oldValue, Object newValue) {
        this.source = source;
        this.propertyname = propertyname;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Object getSource() {
        return source;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropertyChangedEvent{");
        sb.append("source=").append(source);
        sb.append(", propertyname='").append(propertyname).append('\'');
        sb.append(", oldValue=").append(oldValue);
        sb.append(", newValue=").append(newValue);
        sb.append('}');
        return sb.toString();
    }
}
