/*
 * ExprClient.java - Part of QuartzSkript 
 * QuartzCraft (C) QuartzCraft 2014
 * Code by nfell2009
 * 
*/

package uk.co.quartzcraft.quartzskript.ChestShop;

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

public abstract class ExpVelocity extends SimplePropertyExpression<Entity, Vector> {

	public Vector convert(Entity[] entity) {
		for (Entity e : entity) {
			return e.getVelocity();
		}
		if (entity == null) {
			return null;
		}
		return null;
	}

	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
		Entity[] entity = getExpr().getAll(e);
		if(entity == null)
			return;
		Vector v = (Vector) delta[0];
		for (Entity entity1 : entity){
			if (mode == Changer.ChangeMode.SET){
				entity1.setVelocity(v);
			}
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final ChangeMode mode) {
		if (mode == Changer.ChangeMode.SET) //SET can be replaced with REMOVE ADD or similiar stuff.
			return CollectionUtils.array(Boolean.class); //The Class should be the TypeToGet and in this case Number.
		if (mode == Changer.ChangeMode.REMOVE)
			return CollectionUtils.array(Boolean.class);
		return null;
	}

	@Override
	public Class<? extends Vector> getReturnType() { //ReturnType is TypeToGet and in this case Number.
		return Vector.class;

	}
	@Override
	protected String getPropertyName() {
		// TODO Auto-generated method stub
		return "Velocity";
	}

}