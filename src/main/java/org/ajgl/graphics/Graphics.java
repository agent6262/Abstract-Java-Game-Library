/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Tyler Bucher
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.ajgl.graphics;

import org.ajgl.graphics.UtilAnnotations.GlTextureFormat;
import org.lwjgl.opengl.GL11;

/**
 * This class is designed to provide basic and general graphical functions.
 *
 * @author Tyler Bucher
 */
public class Graphics {

    /**
     * Enables an OpenGL state.
     *
     * @param state the list of OpenGL states to enable.
     */
    public static void enableClientSideState(int... state) {
        for (int aState : state)
            GL11.glEnableClientState(aState);
    }

    /**
     * Disables an OpenGL state.
     *
     * @param state the list of OpenGL states to disable.
     */
    public static void disableClientSideState(int... state) {
        for (int aState : state)
            GL11.glDisableClientState(aState);
    }

    /**
     * Binds the textureID to the current OpenGL context.
     *
     * @param textureFormat the {@link GlTextureFormat} to use.
     * @param textureID the id of the texture.
     * @see GlTextureFormat
     */
    public static void bindTexture(@GlTextureFormat int textureFormat, int textureID) {
        GL11.glBindTexture(textureFormat, textureID);
    }
}
