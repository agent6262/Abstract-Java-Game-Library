#version 150

in vec3 in_Position;
in vec3 in_Color;

out vec4 pass_Color;

void main(void) {
    gl_Position = vec4(in_Position, 1.0);
    pass_Color = vec4(in_Color, 1.0);
}