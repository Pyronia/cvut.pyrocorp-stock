package eu.pyrocorp.model.market;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Michal Hubálek.
 */
@Embeddable
public class MarketStateKey implements Serializable
{
    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "timestamp")
    private LocalDate timestamp;

    public MarketStateKey() {}

    public MarketStateKey(Long updatedBy, LocalDate timestamp)
    {
        this.updatedBy = updatedBy;
        this.timestamp = timestamp;
    }

    public Long getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public LocalDate getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof MarketStateKey)) return false;
        MarketStateKey marketStateKey = (MarketStateKey) o;
        return Objects.equals(getUpdatedBy(), marketStateKey.getUpdatedBy()) &&
               Objects.equals(getTimestamp(), marketStateKey.getTimestamp());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getTimestamp(), getUpdatedBy());
    }
}
