package uk.co.quartzcraft.quartzskript;

import javax.annotation.Nullable;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import com.Acrobot.ChestShop.Events.TransactionEvent;

public class ExprClient extends SimpleExpression<Player> {
	 
    @Override
    public Class<? extends Player> getReturnType() {
            return Player.class;
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
            return "Returns client";
    }

    @Override
    @Nullable
    protected Player[] get(Event e) {
            return new Player[] { ((TransactionEvent) e).getClient() };
    }

}