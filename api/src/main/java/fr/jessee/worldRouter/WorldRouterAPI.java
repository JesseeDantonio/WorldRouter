package fr.jessee.worldRouter;

import fr.jessee.worldRouter.iface.WRProvider;

public class WorldRouterAPI {

    private static WRProvider provider = null;

    public static WRProvider get() {
        if (provider == null) {
            throw new IllegalStateException("L'interface WRProvider n'est pas encore chargée !");
        }
        return provider;
    }

    public static void register(WRProvider provider) {
        WorldRouterAPI.provider = provider;
    }

    private WorldRouterAPI() {}
}
