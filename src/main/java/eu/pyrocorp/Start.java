package eu.pyrocorp;

import eu.pyrocorp.model.market.MarketState;
import eu.pyrocorp.model.market.MarketStateDAO;
import eu.pyrocorp.model.market.MarketStateKey;

import java.time.LocalDate;

/**
 * Created by Michal Hubálek.
 */
public class Start
{
    public static void main(String[] args)
    {
        System.out.println("Hello, we are up and running!");
        //new MainWindow();
        MarketState marketState = new MarketState();
        marketState.setHalted(false);
        marketState.setMarketStateKey(new MarketStateKey(2L, LocalDate.now()));
        MarketStateDAO.getInstance().merge(marketState);
    }

}
