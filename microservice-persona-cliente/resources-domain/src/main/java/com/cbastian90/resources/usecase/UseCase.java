package com.cbastian90.resources.usecase;

import com.cbastian90.resources.kernel.command.Command;

@FunctionalInterface
public interface UseCase<T extends Command, R> {
    R execute(T command);
}
