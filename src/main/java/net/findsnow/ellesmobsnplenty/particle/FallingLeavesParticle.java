package net.findsnow.ellesmobsnplenty.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(value= EnvType.CLIENT)
public class FallingLeavesParticle
        extends SpriteBillboardParticle { ;
  private float field_43369;
  private final float field_43370;
  private final float field_43371;

  protected FallingLeavesParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                                      double xd, double yd, double zd, SpriteProvider spriteSet) {
    super(world, xCoord, yCoord, zCoord, xd, yd, zd);
    this.setSprite(spriteSet.getSprite(this.random));
    this.gravityStrength = 0.004f;
    this.maxAge = 120;
    this.scale = 0.1f;
    this.setColor(1.0f, 1.0f, 1.0f);
    this.setBoundingBoxSpacing(0.01f, 0.01f);
    this.collidesWithWorld = true;
    this.velocityX = xd;
    this.velocityY = yd;
    this.velocityZ = zd;
    this.field_43369 = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
    this.field_43370 = this.random.nextFloat();
    this.field_43371 = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
  }


  @Override
  public ParticleTextureSheet getType() {
    return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
  }

  @Override
  public void tick() {
    this.prevPosX = this.x;
    this.prevPosY = this.y;
    this.prevPosZ = this.z;
    if (this.maxAge-- <= 0) {
      this.markDead();
    }
    if (this.dead) {
      return;
    }
    float f = 300 - this.maxAge;
    float g = Math.min(f / 300.0f, 1.0f);
    double d = Math.cos(Math.toRadians(this.field_43370 * 60.0f)) * 2.0 * Math.pow(g, 1.25);
    double e = Math.sin(Math.toRadians(this.field_43370 * 60.0f)) * 2.0 * Math.pow(g, 1.25);
    this.velocityX += d * (double)0.0025f;
    this.velocityZ += e * (double)0.0025f;
    this.velocityY -= this.gravityStrength;
    this.field_43369 += this.field_43371 / 20.0f;
    this.prevAngle = this.angle;
    this.angle += this.field_43369 / 20.0f;
    this.move(this.velocityX, this.velocityY, this.velocityZ);
    if (this.onGround || this.maxAge < 299 && (this.velocityX == 0.0 || this.velocityZ == 0.0)) {
      this.markDead();
    }
    if (this.dead) {
      return;
    }
    this.velocityX *= this.velocityMultiplier;
    this.velocityY *= this.velocityMultiplier;
    this.velocityZ *= this.velocityMultiplier;
  }

  public static class Factory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;
    public Factory(SpriteProvider spriteProvider) {
      this.spriteProvider = spriteProvider;
    }
    public Particle createParticle(DefaultParticleType type, ClientWorld clientWorld,
                                   double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
      return new FallingLeavesParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
    }
  }
}
