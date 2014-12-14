package uk.co.quartzcraft.quartzskript;

import javax.annotation.Nullable;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;

import org.bukkit.block.Sign;
import org.bukkit.event.Event;

import com.Acrobot.ChestShop.Events.TransactionEvent;
import com.Acrobot.ChestShop.Events.TransactionEvent.TransactionType;

public class ExprQuantity extends SimpleExpression<String> {
	 
    @Override
    public Class<? extends String> getReturnType() {
            return String.class;
    }

    @Override
    public boolean isSingle() {
            return true;
    }

    @Override
    public boolean init(Expression<?>[] e, int i, Kleenean kl, ParseResult pr) {
            if (!ScriptLoader.isCurrentEvent(TransactionEvent.class)) {
                    Skript.error(
                                    "Cannot use client in other events other than the transaction event",
                                    ErrorQuality.SEMANTIC_ERROR);
                    return false;
            }
            return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
            return "Returns stock";
    }

    @Override
    @Nullable
    protected String[] get(Event e) {
    		Sign sign = ((TransactionEvent) e).getSign();
    		TransactionType t = ((TransactionEvent) e).getTransactionType();
    		String l2 = sign.getLine(2);
    		String out = "";
    		if (t == TransactionType.BUY) {
    			out = l2.replace("B ", "");
    		} else {
    			out = l2.replace(": S", "");
    		}
            return new String[] { out };
    }

}