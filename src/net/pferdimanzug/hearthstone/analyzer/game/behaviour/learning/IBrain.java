package net.pferdimanzug.hearthstone.analyzer.game.behaviour.learning;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;

public interface IBrain {

	public abstract double getEstimatedUtility(double[] output);

	public abstract double[] getOutput(GameContext context, int playerId);

	public abstract boolean isLearning();

	public abstract void learn(GameContext originalState, int playerId, double[] nextOutput, double reward);

	public abstract void load(String savePath);

	public abstract void save(String savePath);

	public abstract void setLearning(boolean learning);

}