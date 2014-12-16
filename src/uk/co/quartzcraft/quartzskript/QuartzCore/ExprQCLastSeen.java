package uk.co.quartzcraft.quartzskript.QuartzCore;

import javax.annotation.Nullable;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import uk.co.quartzcraft.core.data.QPlayer;

public class ExprQCLastSeen extends Condition {
	 
	 
    private Expression<Player> player;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] expr, int i, Kleenean kl, ParseResult pr) {
            player = (Expression<Player>) expr[0];
            return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean b) {
            return "Returning player data for last seen";
    }

    @Override
    public boolean check(Event e) {
            Player p = player.getSingle(e);
            if (p == null)
                    return false;
            QPlayer player = new QPlayer(p);
            String time = player.getLastSeen();
            return (time) != null;
    }

}