package eu.pyrocorp.model.market;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Michal Hubálek.
 */
@Entity
@Table(schema = "pyrocorp_stock", name = "market_state")
public class MarketState
{
    @EmbeddedId
    private MarketStateKey marketStateKey;

    @Column(name = "is_halted")
    private Boolean isHalted;

    public MarketStateKey getMarketStateKey()
    {
        return marketStateKey;
    }

    public void setMarketStateKey(MarketStateKey marketStateKey)
    {
        this.marketStateKey = marketStateKey;
    }

    public Boolean getHalted()
    {
        return isHalted;
    }

    public void setHalted(Boolean halted)
    {
        isHalted = halted;
    }
}
