package exceptions;

import entities.Entity;

public class AnimationUnsupported extends Exception
{

    public AnimationUnsupported(Entity entity, String anim)
    {
        super(entity.getName() + " does not support the " + anim + " animation.");
    }

}