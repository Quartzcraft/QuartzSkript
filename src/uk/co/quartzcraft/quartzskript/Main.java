package uk.co.quartzcraft.quartzskript;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.Acrobot.ChestShop.Events.TransactionEvent;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;

public class Main extends JavaPlugin {
	 @Override
	    public void onEnable() {
		 Skript.registerEvent("On ChestShop Transaction", SimpleEvent.class, TransactionEvent.class, "chestshop transaction");
		 Skript.registerExpression(ExprClient.class, Player.class, ExpressionType.SIMPLE, "client");
		 Skript.registerExpression(ExprPrice.class, Number.class, ExpressionType.SIMPLE, "price");
		 
		 EventValues.registerEventValue(TransactionEvent.class,
			        Player.class, new Getter<Player, TransactionEvent>() {
			                @Override
			                @javax.annotation.Nullable
			                public Player get(TransactionEvent e) {
			                        return (Player) e.getClient();
			                }
		 			}, 0);
		}
}