/*
 * ExprQuantity.java - Part of QuartzSkript 
 * QuartzCraft (C) QuartzCraft 2014
 * Code by nfell2009
 * 
*/

package uk.co.quartzcraft.quartzskript;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.Acrobot.ChestShop.Events.TransactionEvent;
import com.Acrobot.ChestShop.Events.TransactionEvent.TransactionType;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;

import uk.co.quartzcraft.quartzskript.ChestShop.*;

public class Main extends JavaPlugin {
	 @Override
	    public void onEnable() {
		 
		 /*
		  * 	Start of ChestShop
		  */
		 Skript.registerEvent("On ChestShop Transaction", SimpleEvent.class, TransactionEvent.class, "chestshop transaction");
		 Skript.registerExpression(ExprOwner.class, OfflinePlayer.class, ExpressionType.SIMPLE, "owner");
		 Skript.registerExpression(ExprClient.class, Player.class, ExpressionType.SIMPLE, "client");
		 Skript.registerExpression(ExprPrice.class, Number.class, ExpressionType.SIMPLE, "price");
		 Skript.registerExpression(ExprQuantity.class, String.class, ExpressionType.SIMPLE, "quantity");
		 Skript.registerExpression(ExprTranstype.class, TransactionType.class, ExpressionType.SIMPLE, "transaction type");
		 
		 EventValues.registerEventValue(TransactionEvent.class,
			        Player.class, new Getter<Player, TransactionEvent>() {
			                @Override
			                @javax.annotation.Nullable
			                public Player get(TransactionEvent e) {
			                        return (Player) e.getClient();
			                }
		 			}, 0);
		}
	 
	 	/*
	 	 * 		End of ChestShop	 	 
	 	 */
}